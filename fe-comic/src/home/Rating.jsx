import React, { useEffect, useState } from "react";
import ApiClient from "../assets/js/ApiClient";
import "../assets/css/home/rating.css";

const Rating = () => {
	const [rating, setRatings] = useState();
	useEffect(() => {
		fetchRating();
	}, []);

	const fetchRating = async () => {
		const response = await ApiClient.get(
			"/comic/search?type=popular&size=12"
		).then((r) => r.data);
		setRatings(response);
	};

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
					{rating?.map((item) => (
						<div className="col-lg-3 col-md-4 col-sm-6" key={item.id}>
							<div className="service-item">
								<img
									className="media-object"
									src={
										"https://drive.google.com/thumbnail?id=" +
										item.image +
										"&sz=w150"
									}
									alt="Image"
								/>
								<h4>{item.title}</h4>
								<p>{item.description.substring(0, 50)}</p>
							</div>
						</div>
					))}
				</div>
			</div>
		</section>
	);
};

export default Rating;
