import React, { useState, useEffect } from "react";
import ApiClient from "../assets/js/ApiClient";
import { Link } from "react-router-dom";

const NewestComic = () => {
	const [newest, setNewest] = useState();

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		const response = await ApiClient.get(
			`/comic/search?type=newest&size=4`
		).then((r) => r.data);
		setNewest(response);
	};

	return (
		<div className="widget widget-latest-post">
			<h4 className="widget-title">Newest Comic</h4>
			{newest?.map((item) => (
				<div className="media" key={item.id}>
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
							<Link to={{ pathname: `/comic/${item.id}` }}>{item.title}</Link>
						</h4>
						<p>{item.description.substring(0, 50)}</p>
					</div>
				</div>
			))}
		</div>
	);
};

export default NewestComic;
