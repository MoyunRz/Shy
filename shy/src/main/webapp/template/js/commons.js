

/**
 * 刷新子页,关闭弹窗
 */
function refresh() {
    //根据传递的name值，获取子iframe窗口，执行刷新
    if(window.frames[iframeObjName]) {
        window.frames[iframeObjName].location.reload();

    } else {
        window.location.reload();
    }

    layer.closeAll();
}

/*
*
* 显示模态对话框
*
* */

function showModelWindow(layer,url,width,height,title,id) {
    layer.open({
        type: 2
        ,title: title
        ,area: [width, height]
        ,shade: 0
        ,maxmin: true
        ,content: url
        ,id: id
        ,zIndex: layer.zIndex
    });
}

function showModelWindowByData(layer,url,width,height,title,id,data) {
    layer.open({
        type: 2
        ,title: title
        ,area: [width, height]
        ,shade: 0
        ,maxmin: true
        ,content: url,
        id: id
        ,zIndex: layer.zIndex
        ,success: function(layero,index){

            const body = layer.getChildFrame('body',index);
            var json_value;
            if(Array.isArray(data)){
                json_value = data[0];
            }else{
                json_value = data;
            }
            for(const key in json_value){

                    body.find('#'+key).val(json_value[key]);

            }

        }
    });
}
/**
 * name layui合并tbody中单元格的方法
 * @param tableId  表格的id属性
 * @param fieldName 要合并的列field值
 * @desc 此方式适用于没有列冻结的单元格合并
 */
function tableRowSpanNoFixedCol(tableId, fieldName) {
    if (!tableId && !fieldName) {
        console.log('tableId, fieldName为必填项');
        return false;
    }
    // 获取页面中全部的表格元素
    var allTableNode = document.getElementsByClassName("layui-table-view");

    // 获取lay-id属性为tableId的表格元素的
    var targetTableNode = null;
    if (allTableNode.length > 0) {
        for (var index = 0, length = allTableNode.length; index < length; index++) {
            // 通过lay-id属性过滤表格元素
            var tableLayId = allTableNode[index].getAttribute("lay-id");
            if (tableLayId === tableId) {
                targetTableNode = allTableNode[index];
                break;
            }
        }
    }
    if (!targetTableNode) {
        console.log('没有找到ID为：' + tableId + '的表格, 请升级您的layui版本');
        return false;
    }

    // 开始合并单元格操作
    var tBodyNode = targetTableNode.getElementsByClassName("layui-table-body")[0];

    var tdNodes = tBodyNode.getElementsByTagName("td");
    var childFilterArr = [];
    // 获取data-field属性为fieldName的td
    for (var i = 0; i < tdNodes.length; i++) {
        if (tdNodes[i].getAttribute("data-field") === fieldName) {
            childFilterArr.push(tdNodes[i]);
        }
    }

    // 获取td的个数和种类
    var childFilterTextObj = {};
    var childFilterArrLength = childFilterArr.length;
    for (var j = 0; j < childFilterArrLength; j++) {
        var childText = childFilterArr[j].textContent;
        if (childFilterTextObj[childText] === undefined) {
            childFilterTextObj[childText] = 1;
        } else {
            var num = childFilterTextObj[childText];
            childFilterTextObj[childText] = num * 1 + 1;
        }
    }
    // 给获取到的td设置合并单元格属性
    for (var key in childFilterTextObj) {
        var tdNum = childFilterTextObj[key];
        var canRowSpan = true;
        var needChangeBackGroundNodes = [];
        var addEventNode = null;
        for (var h = 0; h < childFilterArrLength; h++) {
            if (childFilterArr[h].textContent === key) {
                needChangeBackGroundNodes.push(childFilterArr[h]);
                if (canRowSpan) {
                    childFilterArr[h].setAttribute("rowspan", tdNum);
                    addEventNode = childFilterArr[h];
                    canRowSpan = false;
                } else {
                    childFilterArr[h].style.display = "none";
                }
            }
        }

        // 以下为单元格鼠标悬浮样式修改(使用闭包)
        (function (addEventNode, needChangeBackGroundNodes) {
            addEventNode.onmouseover = function () {
                for (var index = 0, length = needChangeBackGroundNodes.length; index < length; index++) {
                    needChangeBackGroundNodes[index].parentNode.style.background = "#f2f2f2"; // 我这里的单元格鼠标滑过背景色为layui默认，你可以更改为你想要的颜色。
                }
            };
            addEventNode.onmouseout = function () {
                for (var index = 0, length = needChangeBackGroundNodes.length; index < length; index++) {
                    needChangeBackGroundNodes[index].parentNode.style.background = "";
                }
            };
        })(addEventNode, needChangeBackGroundNodes);
    }
}
//原始未封装
function editUser(edit) {
    var index = layui.layer.open({
        title: "编辑用户",
        type: 2,
        content: "addClientOrder.html",//弹出层页面
        area: ['500px', '560px'],
        success: function (layero, index) {
            var body = layui.layer.getChildFrame('body', index);
            if (edit) {
                // 取到弹出层里的元素，并把编辑的内容放进去
                body.find("#ostatus").val(edit.ostatus);  //将选中的数据的id传到编辑页面的隐藏域，便于根据ID修改数据
                // 记得重新渲染表单
                form.render();
            }
            setTimeout(function () {
                layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                    tips: 3
                });
            }, 500)
        }
    })
}