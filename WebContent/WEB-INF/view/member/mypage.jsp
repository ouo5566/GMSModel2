<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MYPAGE</title>
	<style>
		.height-100px {height:100px}
		.height-650px {height:650px}
		.height-full {height:100%}
		.width-full {width:100%}
		.width-80per {width:80%}
		.width-70per {width:70%}
		.width-60per {width:60%}
		.font-size-400per {font-size:400%}
		.margin-auto {margin: 0 auto}
		#mypage-tab-Layout {background-color:#e6f9ff}
		#mypage-tab-Layout-logout-butt{background-color:#ffe6e6; width:300px; height:300px; color:white; font-size:200%}
		table, th, td {
			border : 1px solid white;
			text-align : center;
		}
		th, td{
			font-size : 200%;
		}
	</style>
</head>
<body>
	<table id="mypage-tab-Layout" class="width-80per height-650px margin-auto">
		<tr class="height-100px">
			<th colspan="2">GMS</th>
		</tr>
		<tr>
			<td class="width-70per font-size-400per">M Y P A G E</td>
			<td><a href="../home/hello.html">
				<button id="mypage-tab-Layout-logout-butt">LOGOUT</button>
				</a></td>
		</tr>
		<tr class="height-100px">
			<td colspan="2">ADDRESS</td>
		</tr>
	</table>
</body>
</html>

