   // 아이디 유효성 검사
   $('input[name=user_id]').focusout(function() {
      var userId = $('input[name=user_id]').val();
      var ckid = /^[a-z0-9_-]{4,20}$/;
      if(!ckid.test(userId)) {
            $('#must-id').text("필수 입력 항목 입니다.");
        } else if(ckid.test(userId)) {
            $('#must-id').text("");
        }
   });

   // 비밀번호 유효성 검사
   $('input[name=user_pw]').focusout(function() {
      var userPw = $('input[name=user_pw]').val();
      var ckpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
      if(userPw == "") {
            $('#must-pw').text("필수 입력 항목 입니다.");
        } else if(ckpw.test(userPw)){
            $('#must-pw').text("");
            $('.divii').css("display","none");
        } else if(!ckpw.test(userPw)) {
            	$('#must-pw').text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
            	$('#must-pw').css({"position": "relative", "right": "43px"});
            }
   });

   // 비밀번호 일치 확인
   $('input[name=password_check]').focusout(function(){
      var userPw = $('input[name=user_pw]').val();
      var userPwCk = $('input[name=password_check]').val();
      var ckpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,32}$/;

      if(!ckpw.test(userPwCk)) {
         $('#must-pw-ck').text("비밀번호가 일치 하지 않습니다.");
         $('#must-pw-ck').css({"position": "relative", "right": "90px"});
         } else if(userPw == userPwCk){
            $('#must-pw-ck').text("");
         }
   });

   // 이름 유효성 검사
   $('input[name=user_name]').focusout(function() {
      var userName = $('input[name=user_name]').val();
      var ckName = /^[가-힣a-zA-Z]{2,4}$/;

      if(!ckName.test(userName)) {
         $('#must-name').text("필수 입력 항목 입니다.");
      } else if(ckName.test(userName)){
         $('#must-name').text("");
      }
   });
   // 연락처 유효성 검사
   $('input[name=user_phone]').focusout(function() {
      var userPhone = $('input[name=user_phone]').val();
      var ckPhone = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;

      if(!ckPhone.test(userPhone)) {
         $('#must-phone').text("필수 입력 항목 입니다.");
      } else if(ckPhone.test(userPhone)){
         $('#must-phone').text("");
      }
   });

   // 이메일 유효성 검사 
   $('input[name=user_email]').focusout(function() {
      var userEmail = $('input[name=user_email]').val();
      var ckEmail = /^[a-z0-9_+.-]+@([a-z0-9]+\.)+[a-z0-9]{2,4}$/;

      if(!ckEmail.test(userEmail)) {
         $('#must-email').text("필수 입력 항목 입니다.");
      } else if(ckEmail.test(userEmail)){
         $('#must-email').text("");
      }
   });

// input 비어있으면 가입하기 버튼을 누를 수 없음
$('#sign-btn').hover(function() {
   var a = document.getElementsByTagName("input");

   for(var i=0; i < 6; i++){
       if(a[i].value != ""){
         $('#sign-btn').css({"background-color": "yellow", "color": "black"});
       } else if(a[i].value == "") {
         $('#sign-btn').css({"background-color": "white", "color": "gray"});
       }
   }
});

// 로그인 실패
$('input[name=user_id').focusout(function(){
   var a = $('input[name=user_id').val();

   if(a != ""){
      $('.sign-id-check').remove();
   }
});


