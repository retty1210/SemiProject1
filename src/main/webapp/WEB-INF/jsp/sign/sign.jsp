<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="static/css/sign.css">
    <link
        href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp"
        rel="stylesheet">
</head>

<body>
    <div class="main-area">
        <form name="sign_form" action="/sign" method="post">
            <div class="main-area-box">
                <div class="main-area-box_header">
                    <span class="material-icons-outlined"><a href="메인주소">pets</a></span>
                    <span>회원가입</span>
                </div>
                <div class="main-area-box_body">
                    <div class="sign-up_input">
                        <input type="text" name="user_id" class="id-input" placeholder="아이디">
                        <span id="must-id"  class="hid_span_area">
                            <!--필수 입력입니다.-->
                        </span>
                    </div>
                    <div class="sign-up_input">
                        <input type="password" name="user_pw" placeholder="비밀번호">
                        <span id="must-pw" class="hid_span_area">
                            <!-- 필수 입력입니다.-->
                            <!-- 특수문자 포함 관련 내용-->
                        </span>
                    </div>
                    <div class="sign-up_input">
                        <input type="password" name="password_check" placeholder="비밀번호 확인">
                        <span id="must-pw-ck" class="hid_span_area">
                            <!-- 필수 입력입니다.-->
                            <!-- 비밀번호가 일치하지 않습니다.-->
                        </span>
                    </div>
                    <div class="sign-up_input">
                        <input type="text" name="user_name" placeholder="이름">
                        <span id="must-name" class="hid_span_area">

                        </span>
                    </div>
                    <div class="sign-up_input">
                        <input type="text" name="user_phone" placeholder="연락처">
                        <span id="must-phone" class="hid_span_area">
                        </span>
                    </div>
                    <div class="sign-up_input">
                        <input type="email" name="user_email" placeholder="이메일">
                        <span id="must-email" class="hid_span_area">
                            
                        </span>
                    </div>
                </div>
                <div class="main-area-box_footer">
                    <button type="submit" id="sign-btn">가입하기</button>
                </div>
            </div>
        </form>
    </div>
    <footer>
        <hr>
        <p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
        <a href="#"></a>
        <p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
    </footer>
<script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="static/js/sign.js"></script>
</body>
</html>