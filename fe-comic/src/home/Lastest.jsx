import React from 'react'
import {Link} from 'react-router-dom'

const Lastest = ({lastest}) => {
  return (
    <section>
		<div className="container">
			<div className="row">
				<div className="col-12">
					<h4 className="widget-title">Hot comic</h4>
				</div>
			</div>
			<div className="widget widget-latest-post">
				<div className="row">
					{lastest?.map(item => (
						<div className="col-4 media">
						<a className="pull-left" href="blog-single.html">
							<img className="media-object" src="images/blog/post-thumb.jpg" alt="Image" />
						</a>
						<div className="media-body">
							<h4 className="media-heading"><Link to={{pathname: `/comic/${item.titleList[0].titleNo}`}}>{item.titleList[0].title}</Link></h4>
							<p>{item.titleList[0].synopsis}</p>
						</div>
					</div>
					))}
						
				</div>
			</div>
		</div>
	</section>
  )
}

export default Lastest