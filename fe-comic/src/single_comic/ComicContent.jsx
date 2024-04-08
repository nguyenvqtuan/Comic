import React from 'react'

const ComicContent = () => {
  return (
    <section className="portfolio-single-page section-sm">
    <div className="container">
      <div className="row align-items-center">
        <div className="col-xl-8 col-lg-7">
          <div className="portfolio-single-slider">
            <div>
              <img
                className="img-fluid"
                src="images/portfolio/portfolio-big-1.jpg"
              />
            </div>
            <div>
              <img
                className="img-fluid"
                src="images/portfolio/portfolio-big-2.jpg"
              />
            </div>
            <div>
              <img
                className="img-fluid"
                src="images/portfolio/portfolio-big-3.jpg"
              />
            </div>
            <div>
              <img
                className="img-fluid"
                src="images/portfolio/portfolio-big-4.jpg"
              />
            </div>
            <div>
              <img
                className="img-fluid"
                src="images/portfolio/portfolio-big-5.jpg"
              />
            </div>
            <div>
              <img
                className="img-fluid"
                src="images/portfolio/portfolio-big-6.jpg"
              />
            </div>
          </div>
        </div>
        <div className="col-xl-4 col-lg-5 mt-5 mt-lg-0">
          <div className="project-details">
            <h4>Project Details</h4>
            <ul>
              <li>
                <span><i className="fa fa-shirtsinbulk"></i> Client</span
                ><strong>Jannie Kelonsky</strong>
              </li>
              <li>
                <span><i className="fa fa-shield"></i> What We Did</span
                ><strong>Website Redesign</strong>
              </li>
              <li>
                <span><i className="fa fa-ils"></i> Tools Used</span
                ><strong>Photoshop,Illustrator</strong>
              </li>
              <li>
                <span><i className="icon-calendar3"></i>Completed on:</span> 17th
                March 2020
              </li>
              <li>
                <span><i className="icon-lightbulb"></i>Skills:</span> HTML5 / PHP
                / CSS3
              </li>
              <li>
                <span><i className="icon-link"></i>Client:</span>
                <a href="index.html">Google</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div className="row">
        <div className="col-md-12">
          <div className="project-content mt-50">
              <p>
                  <a className="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                    Link with href
                  </a>
                  <button className="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                    Button with data-target
                  </button>
                </p>
                <div className="collapse" id="collapseExample">
                  <div className="card card-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                  </div>
                </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  )
}

export default ComicContent