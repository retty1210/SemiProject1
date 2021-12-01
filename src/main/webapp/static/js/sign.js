function checkJoin() {
   // 아이디 유효성 검사
   $('input[name=user_id]').focusout(function() {
      var value1 = $('input[name=user_id]').val();
      var ckid = /^[a-z0-9_-]{4,20}$/;
   
      if(!ckid.test(value1)) {
            $('#must-id').text("필수 입력 항목 입니다.");
            $('#must-id').css({"display": "block", "color": "red", "font-size": "10px",
                                 "position": "relative", "right": "110px", "margin-top": "4px"});
        } else if(ckid.test(value1)){
            $('#must-id').text("");
        }
   });

   // 비밀번호 유효성 검사
   $('input[name=user_pw]').focusout(function() {
      var value2 = $('input[name=user_pw]').val();
      var ckpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,32}$/;
   
      if(!ckpw.test(value2)) {
            $('#must-pw').text("필수 입력 항목 입니다.");
            $('#must-pw').css({"display": "block", "color": "red", "font-size": "10px",
                                 "position": "relative", "right": "110px", "margin-top": "4px"});
        } else if(ckpw.test(value2)){
            $('#must-pw').text("");
        }
   });

}