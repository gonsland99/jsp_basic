<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<title>�ڵ� �������� ����� ���� �¶��� ���� �ý���</title>
<meta charset="UTF-8">
<title>�������׸��</title>

<link href="../../css/customer/layout.css" type="text/css"
	rel="stylesheet" />
<style>
#visual .content-container {
	height: inherit;
	display: flex;
	align-items: center;
	background: url("/images/mypage/visual.png") no-repeat center;
}
</style>
</head>

<body>
	<!-- header �κ� -->

	<header id="header">

		<div class="content-container">
			<!-- ---------------------------<header>--------------------------------------- -->

			<h1 id="logo">
				<a href="/index.html"> <img src="/images/logo.png" alt="����ó �¶���" />

				</a>
			</h1>

			<section>
				<h1 class="hidden">���</h1>

				<nav id="main-menu">
					<h1>���θ޴�</h1>
					<ul>
						<li><a href="/guide">�н����̵�</a></li>

						<li><a href="/course">���¼���</a></li>
						<li><a href="/answeris/index">AnswerIs</a></li>
					</ul>
				</nav>

				<div class="sub-menu">

					<section id="search-form">
						<h1>���°˻� ��</h1>
						<form action="/course">
							<fieldset>
								<legend>�����˻��ʵ�</legend>
								<label>�����˻�</label> <input type="text" name="q" value="" /> <input
									type="submit" value="�˻�" />
							</fieldset>
						</form>
					</section>

					<nav id="acount-menu">
						<h1 class="hidden">ȸ���޴�</h1>
						<ul>
							<li><a href="/index.html">HOME</a></li>
							<li><a href="/member/login.html">�α���</a></li>
							<li><a href="/member/agree.html">ȸ������</a></li>
						</ul>
					</nav>

					<nav id="member-menu" class="linear-layout">
						<h1 class="hidden">���޴�</h1>
						<ul class="linear-layout">
							<li><a href="/member/home"><img
									src="/images/txt-mypage.png" alt="����������" /></a></li>
							<li><a href="/notice/list.html"><img
									src="/images/txt-customer.png" alt="������" /></a></li>
						</ul>
					</nav>

				</div>
			</section>

		</div>

	</header>

	<!-- --------------------------- <visual> --------------------------------------- -->
	<!-- visual �κ� -->

	<div id="visual">
		<div class="content-container"></div>
	</div>
	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside �κ� -->


			<aside class="aside">
				<h1>ADMIN PAGE</h1>

				<nav class="menu text-menu first margin-top">
					<h1>����������</h1>
					<ul>
						<li><a href="/admin/index.html">������Ȩ</a></li>
						<li><a href="/teacher/index.html">������������</a></li>
						<li><a href="/student/index.html">������������</a></li>
					</ul>
				</nav>

				<nav class="menu text-menu">
					<h1>�˸�����</h1>
					<ul>
						<li><a href="/admin/board/notice/list.html">��������</a></li>
					</ul>
				</nav>

			</aside>
			<!-- --------------------------- main --------------------------------------- -->



			<main class="main">
				<h2 class="main title">��������</h2>

				<div class="breadcrumb">
					<h3 class="hidden">���</h3>
					<ul>
						<li>home</li>
						<li>������</li>
						<li>��������</li>
					</ul>
				</div>

				<div class="search-form margin-top first align-right">
					<h3 class="hidden">�������� �˻���</h3>
					<form class="table-form">
						<fieldset>
							<legend class="hidden">�������� �˻� �ʵ�</legend>
							<label class="hidden">�˻��з�</label> <select name="f">
								<option value="title">����</option>
								<option value="writerId">�ۼ���</option>
							</select> <label class="hidden">�˻���</label> <input type="text" name="q"
								value="" /> <input class="btn btn-search" type="submit"
								value="�˻�" />
						</fieldset>
					</form>
				</div>
				<form action="list" method="post">
					<div class="notice margin-top">
						<h3 class="hidden">�������� ���</h3>
						<table class="table">
							<thead>
								<tr>
									<th class="w60">��ȣ</th>
									<th class="expand">����</th>
									<th class="w100">�ۼ���</th>
									<th class="w100">�ۼ���</th>
									<th class="w60">��ȸ��</th>
									<th class="w40">����</th>
									<th class="w40">����</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="n" items="${list}">
									<tr>
										<td>${n.id}</td>
										<td class="title indent text-align-left"><a
											href="detail?id=${n.id}">${n.title}</a></td>
										<td>${n.writerId}</td>
										<td>${n.regdate}</td>
										<td>${n.hit}</td>
										<td><input type="checkbox" name="open-id" value="${n.id}"></td>
										<td><input type="checkbox" name="del-id" value="${n.id}"></td>
									</tr>
								</c:forEach>



							</tbody>
						</table>
					</div>

					<div class="indexer margin-top align-right">
						<h3 class="hidden">���� ������</h3>
						<div>
							<span class="text-orange text-strong">1</span> / 1 pages
						</div>
					</div>

					<div class="text-align-right margin-top">
						<input type="submit" class="btn-text btn-default" name="cmd" value="�ϰ�����">
						<input type="submit" class="btn-text btn-default" name="cmd" value="�ϰ�����">
						<a class="btn-text btn-default" href="reg.html">�۾���</a>
					</div>
				</form>
				<div class="margin-top align-center pager">

					<div>
						<c:if test="${startNum>1}">
							<a class="btn btn-prev"
								href="?p=${startNum-1}&f=${param.f}&q=${param.q}">����</a>
						</c:if>
						<c:if test="${startNum<=1}">
							<span class="btn btn-prev" onclick="alert('���� �������� �����ϴ�.');">����</span>
						</c:if>


					</div>


					<ul class="-list- center">
						<c:forEach var="i" begin="0" end="4">
							<c:if test="${(startNum+i)<=lastNum}">
								<li><a
									class="-text- ${(page==(startNum+i))?'orange':''} bold"
									href="?p=${startNum+i}&t=&q=">${startNum+i}</a></li>
							</c:if>
						</c:forEach>

					</ul>
					<div>
						<c:if test="${startNum+4<lastNum}">
							<a class="btn btn-next" href="?p=${startNum+5}&t=&q=">����</a>
						</c:if>
						<c:if test="${startNum+4>=lastNum}">
							<span class="btn btn-next" onclick="alert('���� �������� �����ϴ�.');">����</span>
						</c:if>
					</div>

				</div>
			</main>


		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->



	<footer id="footer">
		<div class="content-container">
			<h2 id="footer-logo">
				<img src="/images/logo-footer.png" alt="ȸ������">
			</h2>

			<div id="company-info">
				<dl>
					<dt>�ּ�:</dt>
					<dd>����Ư����</dd>
					<dt>�����ڸ���:</dt>
					<dd>admin@newlecture.com</dd>
				</dl>
				<dl>
					<dt>����� ��Ϲ�ȣ:</dt>
					<dd>111-11-11111</dd>
					<dt>��� �Ǹž�:</dt>
					<dd>�Ű��� 1111 ȣ</dd>
				</dl>
				<dl>
					<dt>��ȣ:</dt>
					<dd>����ó</dd>
					<dt>��ǥ:</dt>
					<dd>ȫ�浿</dd>
					<dt>��ȭ��ȣ:</dt>
					<dd>111-1111-1111</dd>
				</dl>
				<div id="copyright" class="margin-top">Copyright ��
					newlecture.com 2012-2014 All Right Reserved. Contact
					admin@newlecture.com for more information</div>
			</div>
		</div>
	</footer>
</body>

</html>