<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/IconExtension.css">
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/datagrid-detailview.js"></script>
    </head>
    <body>
        <table id="mians" style="width:600px;height:400px"></table>
    <div id="addC" style="display:none;">
        <form id="addForm" method="post" enctype="multipart/form-data">
            <h3>名称：<input name="title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"></h3>
            <h3>封面：<input name="addFileAlb" class="easyui-filebox" style="width:300px"></h3>
            <h3><input type="submit"/></h3>
        </form>
    </div>
    <script type="text/javascript">
        $(function(){
            $('#mians').datagrid({
                url:'${pageContext.request.contextPath }/carousel/findAll',
                fitColumns:true,
                rownumbers:true,
                singleSelect:false,
                ctrlSelect:true,
                columns:[[
                    {title:'名字',field:'title',width:180},
                    {title:'图片',field:'pathImg',width:80},
                ]],
                toolbar:[
                    {
                        text:"上传",
                        iconCls: 'icon-add',
                        handler: function(){
                            $('#addC').dialog({
                                title: 'ヾ(≧O≦)〃嗷~',
                                width: 400,
                                height: 500,
                                closed: false,
                                cache: false,
                                modal: true
                            });
                        }
                    },{
                        iconCls: 'icon-edit',
                        text:'下载',
                        handler: function(){
                            var obj = $("#mians").treegrid('getSelected');
                            if(obj== null){
                                alert("您未选中");
                            }else{
                                //不能用ajax，用ajax不会报错，但是不会进入controller
                                location.href='${pageContext.request.contextPath}/carousel/xiaZai?url='+obj.pathImg;
                            }
                        }
                    }
                ]
            });
            $('#addForm').form({
                url:"${pageContext.request.contextPath}/carousel/addCar",
                onSubmit: function(){
                },
                success:function(data){
                    $("#addC").dialog("close");
                }
            });


        })
    </script>
    </body>
</html>