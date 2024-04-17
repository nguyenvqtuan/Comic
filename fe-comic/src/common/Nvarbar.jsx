import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import ApiClient from "../assets/js/ApiClient";
import "../assets/css/nvarbar.css";

const Nvarbar = () => {
	const [category, setCategory] = useState();
	useEffect(() => {
		fetchCategory();
	}, []);

	const fetchCategory = async () => {
		const response = await ApiClient.get("/category").then((r) => r.data);
		setCategory(response);
	};

	return (
		<header className="navigation">
			<div className="container">
				<div className="row">
					<div className="col-lg-12">
						<nav className="navbar navbar-expand-lg p-0">
							<Link className="navbar-brand" to="/">
								<img src="/src/assets/images/logo.jpg" alt="Logo" />
							</Link>

							<button
								className="navbar-toggler collapsed"
								type="button"
								data-toggle="collapse"
								data-target="#nvarbarCollapse"
								aria-controls="nvarbarCollapse"
								aria-expanded="false"
								aria-label="Toggle navigation">
								<span className="ion-android-menu"></span>
							</button>

							<div
								className="collapse navbar-collapse ml-auto"
								id="nvarbarCollapse">
								<ul className="navbar-nav ml-auto">
									<li className="nav-item">
										<Link to="/" className="nav-link">
											Home
										</Link>
									</li>
									<li className="nav-item dropdown @@rating">
										<a
											className="nav-link dropdown-toggle"
											href="#"
											id="dropdownrating"
											data-toggle="dropdown"
											aria-haspopup="true"
											aria-expanded="false">
											Top <span className="ion-ios-arrow-down"></span>
										</a>
										<ul
											className="dropdown-menu"
											aria-labelledby="dropdownrating">
											<li>
												<Link
													className="dropdown-item @@popularity"
													to={{
														pathname: `/comic/search`,
														search: "?type=popular",
													}}>
													Popularity
												</Link>
											</li>
											<li>
												<Link
													className="dropdown-item @@mostedView"
													to={{
														pathname: `/comic/search`,
														search: "?type=view",
													}}>
													Mosted view
												</Link>
											</li>

											<li>
												<Link
													className="dropdown-item @@commented"
													to={{
														pathname: `/comic/search`,
														search: "?type=comment",
													}}>
													Hot commented
												</Link>
											</li>
										</ul>
									</li>
									<li className="nav-item dropdown @@category">
										<a
											className="nav-link dropdown-toggle"
											href="#"
											id="dropdownrating"
											data-toggle="dropdown"
											aria-haspopup="true"
											aria-expanded="false">
											Category <span className="ion-ios-arrow-down"></span>
										</a>
										<ul
											className="dropdown-menu"
											aria-labelledby="dropdownrating">
											{category?.map((item) => (
												<li key={item.id}>
													<Link
														className="dropdown-item @@popularity"
														to={{
															pathname: `/comic/search`,
															search: `?type=popular&category=${item.name}`,
														}}>
														{item.name}
													</Link>
												</li>
											))}
										</ul>
									</li>
									<li className="nav-item @@login">
										<Link className="nav-link" to="/login">
											Login
										</Link>
									</li>
									<li className="nav-item @@register">
										<Link className="nav-link" to="/register">
											Register
										</Link>
									</li>
									<li className="nav-item @@logout">
										<Link className="nav-link" to="/logout">
											Logout
										</Link>
									</li>
								</ul>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</header>
	);
};

export default Nvarbar;
