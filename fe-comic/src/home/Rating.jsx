import React, {useEffect} from 'react'
import ApiClient from '../assets/js/ApiClient'

const Rating = () => {
  useEffect(() => {
    ApiClient.get("/canvas/home?language=en").then((r) => console.log(r));
  }, [])

  return (
    <section className="service">
    <div className="container">
      <div className="row">
        <div className="col-12 text-center">
          <div className="section-title">
            <h2>Our Services</h2>
          </div>
        </div>
      </div>
      <div className="row">
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="icon ion-coffee"></i>
            <h4>Branding</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-compass"></i>
            <h4>Web Design</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-image"></i>
            <h4>App Design</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-bug"></i>
            <h4>Start Up</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-headphone"></i>
            <h4>Logo Design</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-leaf"></i>
            <h4>Development</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-planet"></i>
            <h4>Brand Identity</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
        <div className="col-lg-3 col-md-4 col-sm-6">
          <div className="service-item">
            <i className="ion-earth"></i>
            <h4>Brand Identity</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
          </div>
        </div>
      </div>
    </div>
  </section>
  )
}

export default Rating