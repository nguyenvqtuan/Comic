import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import ApiClient from "../assets/js/ApiClient";

const OtherComic = () => {
	const [related, setRelated] = useState();
	useEffect(() => {
		fetchRelatedComic();
	}, []);

	const fetchRelatedComic = async () => {
		const response = await ApiClient.get(
			"/comic/search?type=related&category=1&size=4"
		).then((r) => r.data);
		setRelated(response);
	};

	return (
		<section className="related-projects section-sm bg-gray">
			<div className="container">
				<div className="row">
					<div className="col-12">
						<div className="text-center">
							<h2>Related Other Projects</h2>
						</div>
					</div>
				</div>
				<div className="row">
					{related?.map((item) => (
						<div className="col-md-3 mt-5" key={item.id}>
							<div className="content">
								<img
									className="img-fluid"
									src={
										"https://drive.google.com/thumbnail?id=" +
										item.image +
										"&sz=w150"
									}
								/>
								<div className="content mt-4">
									<h4>{item.title}</h4>
									<p>{item.description}</p>
									<Link
										to={{ pathname: `/comic/${item.id}` }}
										className="btn btn-small">
										{item.title}
									</Link>
								</div>
							</div>
						</div>
					))}
				</div>
			</div>
		</section>
	);
};

export default OtherComic;
