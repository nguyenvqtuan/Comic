import React from 'react'

const Rating = ({rating}) => {

  return (
    <section className="service">
    <div className="container">
      <div className="row">
        <div className="col-12 text-center">
          <div className="section-title">
            <h2>Rating</h2>
          </div>
        </div>
      </div>
      <div className="row">
        {rating?.map((item => (
          <div className="col-lg-3 col-md-4 col-sm-6">
            <div className="service-item">
              <i className="icon ion-coffee"></i>
              <h4>{item.titleList[0].title}</h4>
              <p>{item.titleList[0].synopsis.substring(0, 50)}</p>
            </div>
          </div>
        )))}
      </div>
    </div>
  </section>
  )
}

export default Rating