import React from 'react'

const Lastest = () => {
  return (
    <section>
    <div className="container">
        <div className="row">
            <div className="col-12">
                <h4 className="widget-title">Latest Posts</h4>
            </div>
        </div>
        <div className="widget widget-latest-post">
        <div className="row">
		
		<div className="col-4 media">
			<a className="pull-left" href="blog-single.html">
				<img className="media-object" src="images/blog/post-thumb.jpg" alt="Image" />
			</a>
			<div className="media-body">
				<h4 className="media-heading"><a href="blog-single.html">Introducing Swift for Mac</a></h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis, officia.</p>
			</div>
		</div>
		<div className="col-4 media">
			<a className="pull-left" href="blog-single.html">
				<img className="media-object" src="images/blog/post-thumb-2.jpg" alt="Image" />
			</a>
			<div className="media-body">
				<h4 className="media-heading"><a href="blog-single.html">Welcome to Themefisher Family</a></h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis, officia.</p>
			</div>
		</div>
		<div className="col-4 media">
			<a className="pull-left" href="blog-single.html">
				<img className="media-object" src="images/blog/post-thumb-3.jpg" alt="Image" />
			</a>
			<div className="media-body">
				<h4 className="media-heading"><a href="blog-single.html">Warm welcome from swift</a></h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis, officia.</p>
			</div>
		</div>
		<div className="col-4 media">
			<a className="pull-left" href="blog-single.html">
				<img className="media-object" src="images/blog/post-thumb-4.jpg" alt="Image" />
			</a>
			<div className="media-body">
				<h4 className="media-heading"><a href="blog-single.html">Introducing Swift for Mac</a></h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis, officia.</p>
			</div>
		</div>
	</div>
            </div>
        </div>
  </section>
  )
}

export default Lastest