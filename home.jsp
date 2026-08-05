<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OJPMS - Online Job Portal</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/navbar.css">
<link rel="stylesheet" href="assests/home.css">
<link rel="stylesheet" href="https://unpkg.com/aos@2.3.4/dist/aos.css">
</head>

<body>

<jsp:include page="navbar.jsp"/>

<!-- HERO SECTION -->
<section class="hero">

    <div class="container hero-grid">

        <div class="hero-text">

            <h1>Find Your <span>Dream Job</span> Today</h1>

            <p>
                Connect with top recruiters and explore thousands of
                opportunities across India.
            </p>

           <a href="viewjob" class="btn">Explore Jobs</a>

			<a href="register.jsp" class="btn secondary"> Join Now </a>

        </div>

        <div class="hero-box">
            <h2>🔥 Trending Jobs</h2>
            <ul>
                <li>Java Developer - Pune</li>
                <li>Full Stack Developer - Mumbai</li>
                <li>Data Analyst - Bangalore</li>
            </ul>
        </div>

    </div>

</section>

<!-- STATS SECTION -->
<section class="stats">

    <div class="container grid-4">

        <div class="card" data-aos="zoom-in">
            <h2>1000+</h2>
            <p>Jobs Available</p>
        </div>

       <div class="card" data-aos="zoom-in">
            <h2>250+</h2>
            <p>Recruiters</p>
        </div>

        <div class="card" data-aos="zoom-in">
            <h2>5000+</h2>
            <p>Candidates</p>
        </div>

        <div class="card" data-aos="zoom-in">
            <h2>800+</h2>
            <p>Placements</p>
        </div>

    </div>

</section>

<!-- SEARCH SECTION -->
<section class="search-section">

    <div class="container">

        <h2>Search Opportunities</h2>

        <form action="viewjob" class="search-box">

            <input type="text" name="search" placeholder="Job Title / Skills">
            <input type="text" name="location" placeholder="Location">

            <button type="submit" class="btn">Search</button>

        </form>

    </div>

</section>

<!-- FEATURED JOBS -->
<section class="featured">

    <div class="container">

        <h2>Featured Jobs</h2>

        <div class="grid-3">

            <div class="job-card" data-aos="fade-up">
                <h3>Java Developer</h3>
                <p>Pune | Full Time</p>
            </div>

            <div class="job-card" data-aos="fade-up">
                <h3>Full Stack Developer</h3>
                <p>Mumbai | Full Time</p>
            </div>

            <div class="job-card" data-aos="fade-up">
                <h3>Data Analyst</h3>
                <p>Bangalore | Hybrid</p>
            </div>
            
            

        </div>

    </div>

</section>

<!-- WHY SECTION -->
<section class="why">

    <div class="container">

        <h2>Why Choose OJPMS?</h2>

        <div class="grid-3">

            <div class="job-card" data-aos="zoom-in">
                <h3>✔ Verified Jobs</h3>
                <p>All recruiters are verified.</p>
            </div>

            <div class="job-card" data-aos="zoom-in">
                <h3>⚡ Fast Apply</h3>
                <p>Apply in one click.</p>
            </div>

           <div class="job-card" data-aos="zoom-in">
                <h3>🔒 Secure Data</h3>
                <p>Your data is always protected.</p>
            </div>

        </div>

    </div>

</section>

<!-- FOOTER -->
<footer class="footer">

    <div class="container">

        <h3>OJPMS</h3>
        <p>Connecting talent with opportunity.</p>

        <p>© 2026 OJPMS. All Rights Reserved.</p>

    </div>

</footer>
<script src="https://unpkg.com/aos@2.3.4/dist/aos.js"></script>

<script>
AOS.init({
    duration:800,
    once:true
});
</script>
</body>
</html>