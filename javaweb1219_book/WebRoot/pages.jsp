<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="text-align: center;">
	<c:if test="${pageIndex > 1 }">
		<button onclick="toPage(1)">首页</button>
		<button onclick="toPage(${pageIndex-1 })">上一页</button>
	</c:if>
	<c:if test="${pageIndex le 1}">
		<span>首页</span>
		<span>上一页</span>
	</c:if>
	
	<!-- 数字页 -->
	<c:forEach var="i" begin="1" end="${total}">  
		<c:if test="${i < pageIndex || i > pageIndex}">
			<button onclick="toPage(${i})">${i}</button>
		</c:if>
		<c:if test="${i == pageIndex}">${i}</c:if>
	</c:forEach>  
	
	<c:if test="${pageIndex lt total}">
		<button onclick="toPage(${pageIndex+1})">下一页</button>
		<button onclick="toPage(${total})">尾页</button>
	</c:if>
	<c:if test="${pageIndex == total}">
		<span>下一页</span>
		<span>尾页</span>
	</c:if>
	<input type="text" id="pageGo" name="pageGo" size="3" />
	<button onclick="goPage()">Go</button>

</div>

<script type="text/javascript">
	//公用页面跳转功能，将变化的量当成参数传递
	function toPage(pageindex){
		location.href = "${nowPage}&pageIndex="+pageindex;
	}

	//创建goPage()方法实现页面跳转
	function goPage() {
		//获取用户输入的值
		var page = document.getElementById("pageGo").value;
		//判断是否为数字，如果不是数字就提示“请输入数字”
		
			if (page!= null && page!= 0 && (!isNaN(page))) {
				//判断是否小于总页数，若小于就跳转，否则提示
				if (page > ${total} || page < 1) {
					alert("输入大于总页面数");
				} else {
					toPage(page);
				}
			} else {
				alert("请输入正确的值！");
			}
		
	}
</script>
