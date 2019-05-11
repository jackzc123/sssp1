<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/11
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EmpList</title>
    <script type="text/javascript" src="${APP_PATH}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            var oldVal = $("#empNumber").val();

            $("#empNumber").change(function () {
                var pageNum = $(this).val();
                var patt = /^[0-9]*$/;
                if (patt.test(pageNum)) {
                    if (pageNum <= 0) {
                        pageNum = 1;
                    }
                    if (pageNum >= ${emps.totalPages} ) {
                        pageNum = ${emps.totalPages};
                    }

                    var path = "${APP_PATH}/emps?pageNum="+pageNum;

                } else {
                    var path = "${APP_PATH}/emps?pageNum="+oldVal;
                }
                $("#tiaozhuan").attr("href", path);
                document.getElementById("tiaozhuan").click();
            });
            $(".delete").click(function () {
                var href = $(this).attr("href");
                alert(href)
                $("form").attr("action", href).submit();
                return false;
            });

        });
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <a href="${APP_PATH}/emp">新增</a>
    <a type="hidden" id="tiaozhuan" href=""></a>
    <%
        String path = request.getContextPath();
        request.setAttribute("APP_PATH", path);
    %>
    <c:if test="${empty emps}">
        没有员工！！！
    </c:if>
    <c:if test="${not empty emps}">

        <table cellpadding="10" cellspacing="0" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>lastName</th>
                    <th>email</th>
                    <th>age</th>
                    <th>birth</th>
                    <th>createTime</th>
                    <th>departmentName</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${emps.content}" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>${emp.age}</td>
                        <td>${emp.birth}</td>
                        <td>${emp.createTime}</td>
                        <td>${emp.department.name}</td>
                        <td>
                            <a class="delete" href="${APP_PATH}/emp/${emp.id}">删除</a>
                            <a href="${APP_PATH}/emp/${emp.id}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tr>
                <td colspan="4">共${emps.totalElements}条数据，每页${emps.size}条，共${emps.totalPages}页，当前第
                        <input type="text" id="empNumber" value="${emps.number+1}"/>页</td>
                <td colspan="4">
                    <c:if test="${emps.number > 0}">
                        <a href="${APP_PATH}/emps?pageNum=${emps.number}">上一页</a>
                    </c:if>

                    <c:if test="${emps.number < emps.totalPages -1}">
                        <a href="${APP_PATH}/emps?pageNum=${emps.number+2}">下一页</a>
                    </c:if>

                </td>
            </tr>
        </table>

    </c:if>
</body>
</html>
