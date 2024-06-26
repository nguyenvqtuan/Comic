import React, { useEffect, useState } from "react";
import ApiClient from "../assets/js/ApiClient";
import { useParams } from "react-router-dom";
import { ComicInformation } from "./ComicInformation";
import ComicComment from "./ComicComment";
import ComicChapter from "./ComicChapter";
import Introduce from "./Introduce";
import "../assets/css/comic/page-content.css";

const ComicContent = () => {
	const { id } = useParams();
	const [comic, setComic] = useState();
	useEffect(() => {
		fetchComicById();
	}, []);

	const fetchComicById = async () => {
		const response = await ApiClient.get(`/comic/${id}`).then((r) => r.data);
		setComic(response);
	};

	return (
		<section className="portfolio-single-page section-sm">
			<div className="container">
				<div className="row align-items-center">
					<div className="col-xl-5 col-lg-6" id="left-image">
						<img
							className="img-fluid"
							src={
								"https://drive.google.com/thumbnail?id=" +
								comic?.image +
								"&sz=w150"
							}
						/>
					</div>
					<div className="col-xl-4 col-lg-5 mt-5 mt-lg-0">
						<ComicInformation comic={comic} />
					</div>
					<div className="col-xl-3 col-lg-2 mt-5 mt-lg-0"></div>
				</div>
				<div className="row">
					<div className="col-md-12">
						<div className="project-content mt-50">
							<div id="collapse-comic">
								<p>
									<button
										className="ml-2 btn btn-primary"
										type="button"
										data-toggle="collapse"
										data-target="#introduce"
										aria-expanded="false"
										aria-controls="introduce">
										Introduce
									</button>
									<button
										className="ml-2 btn btn-primary"
										data-toggle="collapse"
										data-target="#chapters"
										type="button"
										aria-expanded="false"
										aria-controls="chapters">
										Chapters
									</button>
									<button
										className="ml-2 btn btn-primary"
										type="button"
										data-toggle="collapse"
										data-target="#comments"
										aria-expanded="false"
										aria-controls="comments">
										Comments
									</button>
								</p>
								<div className="row">
									<div className="col">
										<div
											className="collapse multi-collapse"
											id="introduce"
											data-bs-parent="#collapse-comic">
											<Introduce comic={comic} />
										</div>
										<div
											className="collapse multi-collapse"
											id="chapters"
											data-bs-parent="#collapse-comic">
											<div className="card card-body">
												<ComicChapter comicId={id} />
											</div>
										</div>
										<div
											className="collapse multi-collapse"
											id="comments"
											data-bs-parent="#collapse-comic">
											<ComicComment comicId={id} />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	);
};

export default ComicContent;
