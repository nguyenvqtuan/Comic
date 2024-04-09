import React from 'react'
import {Link} from 'react-router-dom'
import '../assets/css/nvarbar.css'

const Nvarbar = () => {
  return (
    <header className="navigation">
        <div className="container">
            <div className="row">
                <div className="col-lg-12">
                    <nav className="navbar navbar-expand-lg p-0">
                        <Link className="navbar-brand" to="/">
                            <img src="/src/assets/images/logo.jpg" alt="Logo" />
                        </Link>
    
                        <button className="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#nvarbarCollapse" aria-controls="nvarbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="ion-android-menu"></span>
                        </button>
    
                        <div className="collapse navbar-collapse ml-auto" id="nvarbarCollapse">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item">
                                    <Link to="/" className="nav-link" >Home</Link>
                                </li>
                                <li className="nav-item dropdown @@rating">
                                    <a className="nav-link dropdown-toggle" href="#" id="dropdownrating" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Top <span className="ion-ios-arrow-down"></span></a>
                                    <ul className="dropdown-menu" aria-labelledby="dropdownrating">
                                        <li><Link className="dropdown-item @@popularity" to="/search">Popularity</Link></li>
                                        <li><Link className="dropdown-item @@mostedView" to="/search">Mosted view</Link></li>
                                        <li><Link className="dropdown-item @@liked" to="/search">Liked</Link></li>
                                        <li><Link className="dropdown-item @@commented" to="/search">Commented</Link></li>
                                    </ul>
                                </li>
                                <li className="nav-item dropdown @@category">
                                    <a className="nav-link dropdown-toggle" href="#" id="dropdownrating" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category <span className="ion-ios-arrow-down"></span></a>
                                    <ul className="dropdown-menu" aria-labelledby="dropdownrating">
                                        <li><Link className="dropdown-item @@popularity" to="/search">A</Link></li>
                                        <li><Link className="dropdown-item @@mostedView" to="/search">B</Link></li>
                                        <li><Link className="dropdown-item @@liked" to="/search">c</Link></li>
                                        <li><Link className="dropdown-item @@commented" to="/search">ComLinkented</Link></li>
                                    </ul>
                                </li>
                                <li className="nav-item @@login"><Link className="nav-link" to="/login">Login</Link></li>
                                <li className="nav-item @@register"><Link className="nav-link" to="/register">Register</Link></li>
                                <li className="nav-item @@logout"><Link className="nav-link" to="/logout">Logout</Link></li>
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