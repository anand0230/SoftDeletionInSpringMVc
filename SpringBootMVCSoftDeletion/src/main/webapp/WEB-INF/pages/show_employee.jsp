<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
<c:when test="${!empty emplist}">
<h1 style="color:red; textalign:center;">Employee Report</h1>
<table border="1" align="center" bgcolor="cyan">
<tr style="color:red;"><th>empno</th><th>ename</th><th>job</th><th>salary</th><th>deptno</th><th>Operations</th></tr>

<c:forEach var="item" items="${emplist}">

<tr>
<td>${item.empno}</td>
<td>${item.ename}</td>
<td>${item.job}</td>
<td>${item.sal}</td>
<td>${item.deptno}</td>
<td>
<a href="edit?no=${item.empno}"><img alt="image not found" height="30px" width="30px" src="../images/edit.png">    </a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?no=${item.empno}" OnClick=" return confirm('Are You sure ')"><img alt="image not found" height="30px" width="30px" src="../images/delete.png">  </a>
</td>
</tr>

</c:forEach>
</table>

</c:when>

<c:otherwise>
   
   <h1 style="color:red">Record Not available</h1>
   
</c:otherwise>
</c:choose>

<center>

<h2 style="color:green; text-align:center;" >${msg}</h2>

<a href="register"><img alt="image not found" src="../images/add.jpg" width="40px" height="50px"> Add Employee</a>&nbsp;&nbsp;&nbsp;&nbsp;

<a href="./"><img alt="image not found" src="../images/home.png" width="40px" height="50px"> Home</a>

</center>
