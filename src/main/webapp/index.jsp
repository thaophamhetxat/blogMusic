<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<style>
    body, h1, h5 {
        font-family: "Raleway", sans-serif
    }

    body, html {
        height: 100%
    }

    .bgimg {
        background-image:url("/img/galaxy.jpg");
        min-height: 100%;
        background-position: center;
        background-size: cover;
    }
</style>
<body>

<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-jumbo">
        <p>logo</p>
    </div>
    <div class="w3-display-topleft w3-container w3-xlarge">
        <p>
            <button onclick="document.getElementById('blog').style.display='block'" class="w3-button w3-black">Blog
            </button>
        </p>
        <p>
            <button onclick="document.getElementById('login').style.display='block'" class="w3-button w3-black">
                Login
            </button>
        </p>
        <p>
            <button onclick="document.getElementById('register').style.display='block'" class="w3-button w3-black">
                Register
            </button>
        </p>
    </div>
    <div class="w3-display-bottomleft w3-container">
        <p class="w3-xlarge">monday - friday 10-23 | saturday 14-02</p>
        <p class="w3-large">42 village St, New York</p>
        <p>powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </div>
</div>

<!-- Menu Modal -->
<div id="blog" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-black w3-display-container">
            <span onclick="document.getElementById('blog').style.display='none'"
                  class="w3-button w3-display-topright w3-large">x</span>
            <h1>Blog</h1>
        </div>
        <div class="w3-container">
            <p>YASUO: Login để có trải nhiệm tốt nhất!</p>
            <a href="/blog" class="w3-button">Truy cập blog với tư cách là khách!</a>
        </div>

    </div>
</div>

<!-- Contact Modal -->
<div id="login" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-black">
            <span onclick="document.getElementById('login').style.display='none'"
                  class="w3-button w3-display-topright w3-large">x</span>
            <h1>Login</h1>
        </div>
        <div class="w3-container">
            <p>YASUO: Login để có trải nhiệm tốt nhất!</p>
            <form action="/login" target="_blank">
                <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Enter Email" required
                          name="email"></p>
                <p><input class="w3-input w3-padding-16 w3-border" type="password" placeholder="Enter PassWord" required
                          name="passWord"></p>
                <p>
                    <button class="w3-button" type="submit">Login</button>
                </p>
            </form>
        </div>
    </div>
</div>

<!-- regiter -->

<div id="register" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-black">
            <span onclick="document.getElementById('register').style.display='none'"
                  class="w3-button w3-display-topright w3-large">x</span>
            <h1>Register</h1>
        </div>
        <div class="w3-container w3-padding-64 w3-blue-grey w3-grayscale-min w3-xlarge">
            <div class="w3-content">
                <p><span class="w3-tag">TIP!</span> Đăng ký thành viên của blog để trải nhiệm tốt nhất</p>
                <form action="/register" target="_blank">
                    <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Enter email" required
                              name="email"></p>
                    <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Enter name" required
                              name="userName"></p>
                    <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Enter password" required
                              name="passWord"></p>
                    <p><span class="w3-tag">YASUO SAID:</span> Bạn đồng ý điều khoản của blog!</p>
                    <p>
                        <button class="w3-button w3-light-grey w3-block" type="submit">Register</button>
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

