import React from 'react'
import '../assets/css/nvarbar.css'

const Nvarbar = () => {
  return (
    <header className="navigation">
        <div className="container">
            <div className="row">
                <div className="col-lg-12">
                    <nav className="navbar navbar-expand-lg p-0">
                        <a className="navbar-brand" href="index.html">
                            <img src="/src/assets/images/logo.jpg" alt="Logo" />
                        </a>
    
                        <button className="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#nvarbarCollapse" aria-controls="nvarbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="ion-android-menu"></span>
                        </button>
    
                        <div className="collapse navbar-collapse ml-auto" id="nvarbarCollapse">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item active">
                                    <a className="nav-link" href="index.html">Home</a>
                                </li>
                                <li className="nav-item dropdown @@rating">
                                    <a className="nav-link dropdown-toggle" href="#" id="dropdownrating" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Top <span className="ion-ios-arrow-down"></span></a>
                                    <ul className="dropdown-menu" aria-labelledby="dropdownrating">
                                        <li><a className="dropdown-item @@popularity" href="search.html">Popularity</a></li>
                                        <li><a className="dropdown-item @@mostedView" href="search.html">Mosted view</a></li>
                                        <li><a className="dropdown-item @@liked" href="search.html">Liked</a></li>
                                        <li><a className="dropdown-item @@commented" href="search.html">Commented</a></li>
                                    </ul>
                                </li>
                                <li className="nav-item dropdown @@category">
                                    <a className="nav-link dropdown-toggle" href="#" id="dropdownrating" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category <span className="ion-ios-arrow-down"></span></a>
                                    <ul className="dropdown-menu" aria-labelledby="dropdownrating">
                                        <li><a className="dropdown-item @@popularity" href="search.html">A</a></li>
                                        <li><a className="dropdown-item @@mostedView" href="search.html">B</a></li>
                                        <li><a className="dropdown-item @@liked" href="search.html">c</a></li>
                                        <li><a className="dropdown-item @@commented" href="search.html">Commented</a></li>
                                    </ul>
                                </li>
                                <li className="nav-item @@login"><a className="nav-link" href="login.html">Login</a></li>
                                <li className="nav-item @@register"><a className="nav-link" href="register.html">Register</a></li>
                                <li className="nav-item @@logout"><a className="nav-link" href="logout.html">Logout</a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
  )
}

export default Nvarbar