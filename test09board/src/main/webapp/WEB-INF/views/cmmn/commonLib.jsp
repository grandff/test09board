<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<!-- 부트스트랩 -->
   	<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
   	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
   	<script src="/resources/js/bootstrap.min.js"></script>
   	
   	<script>
   	// es6 coding
   	const goView = (num) => {
   		const searchNum = document.getElementById("searchNum");
   		searchNum.value = num;
   		document.getElementById("viewForm").submit();	    
	}
   	
   	let sel_file;
   	
   	$(document).ready(function(){
   		$("#multipartFile").on("change", handleImgFileSelect);
   	});
   	
   	const handleImgFileSelect = (e) => {
   		const files = e.target.files;
   		const filesArr = Array.prototype.slice.call(files);
   		
   		filesArr.forEach(function(f){
   			sel_file = f;
   			let reader = new FileReader();
   			reader.onload = function(e){
   				$("#img").attr("src", e.target.result);
   			}
   			reader.readAsDataURL(f);
   		});
   	}

   	
   	</script>
   	
   	<style>
   		.img_wrap{
   			width:300px;
   			margin-top : 50px;   			
   		}
   		
   		.img_wrap img{
   			max-width: 100%;
   		}
   	</style>
</head>