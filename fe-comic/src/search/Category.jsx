import React, { useState, useEffect } from "react";
import ApiClient from "../assets/js/ApiClient";
import { Link } from "react-router-dom";

const Category = () => {
	const [category, setCategory] = useState();

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		const response = await ApiClient.get(`/category`).then((r) => r.data);
		setCategory(response);
	};

	return (
		<div className="widget widget-category">
			<h4 className="widget-title">Categories</h4>
			<ul className="widget-category-list">
				{category?.map((item) => (
					<li key={item.id}>
						<Link
							to={{
								pathName: `/comic/search`,
								search: `?type=popular&category=${item.name}`,
							}}>
							{item.name}
						</Link>
					</li>
				))}

				<li>
					<a href="blog-grid.html">Landscape</a>
				</li>
				<li>
					<a href="blog-grid.html">Portrait</a>
				</li>
				<li>
					<a href="blog-grid.html">Wild Life</a>
				</li>
				<li>
					<a href="blog-grid.html">Video</a>
				</li>
			</ul>
		</div>
	);
};

export default Category;
