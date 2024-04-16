import React, { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import ApiClient from "../assets/js/ApiClient";

const Lastest = ({ lastest }) => {
	const [view, setViews] = useState();
	useEffect(() => {
		fetchView();
	}, []);

	const fetchView = async () => {
		const response = await ApiClient.get(
			"/comic/search?type=view&size=20"
		).then((r) => r.data);
		setViews(response);
	};
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
						{view?.map((item) => (
							<div className="col-4 media" key={item.id}>
								<a className="pull-left" href="blog-single.html">
									<img
										className="media-object"
										src={
											"https://drive.google.com/thumbnail?id=" +
											item.image +
											"&sz=w150"
										}
										alt="Image"
									/>
								</a>
								<div className="media-body">
									<h4 className="media-heading">
										<NavLink to={{ pathname: `/comic/${item.id}` }}>
											{item.title}
										</NavLink>
									</h4>
									<p>{item.description.substring(0, 30)}</p>
								</div>
							</div>
						))}
					</div>
				</div>
			</div>
		</section>
	);
};

export default Lastest;
