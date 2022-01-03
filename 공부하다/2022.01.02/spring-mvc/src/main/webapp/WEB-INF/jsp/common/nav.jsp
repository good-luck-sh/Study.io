<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<div class="container">
    	<ul class="navbar-nav">
      		<li class="nav-item">
        		<a class="nav-link ${menu eq '홈' ? 'active' : '' }" href="/spring-mvc/home.do">홈</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link ${menu eq '부서' ? 'active' : '' }" href="/spring-mvc/dept/list.do">부서관리</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link ${menu eq '직종' ? 'active' : '' }" href="/spring-mvc/job/list.do">직종관리</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link ${menu eq '직원' ? 'active' : '' }" href="/spring-mvc/emp/list.do">직원관리</a>
      		</li>
    	</ul>
  	</div>
</nav>