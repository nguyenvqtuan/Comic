import React, { useState, useEffect } from "react";
import ApiClient from "../assets/js/ApiClient";
import { useSearchParams } from "react-router-dom";

const SearchingContent = () => {
	const [searching, setsearching] = useState();
	const [searchParams, setSearchParams] = useSearchParams();

	useEffect(() => {
		if (
			searchParams.get("category") == undefined ||
			searchParams.get("category") == null
		) {
			searchParams.set("category", "");
		}
		fetchData();
	}, [searchParams]);

	const fetchData = async () => {
		const response = await ApiClient.get(
			`/comic/search?type=${searchParams.get(
				"type"
			)}&cateogry=${searchParams.get("category")}`
		).then((r) => r.data);
		console.log(
			`/comic/search?type=${searchParams.get(
				"type"
			)}&cateogry=${searchParams.get("category")}`
		);
		setsearching(response);
	};

	return (
		<div className="col-8">
			<section className="service pt-0">
				<div className="row">
					{searching?.map((item) => (
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
								<p>{item.description.substring(0, 50)} </p>
							</div>
						</div>
					))}
				</div>
			</section>
		</div>
	);
};

export default SearchingContent;
