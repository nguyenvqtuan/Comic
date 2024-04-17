import React from "react";

const CommentForm = () => {
	return (
		<div className="post-comments-form">
			<h3 className="post-sub-heading">Leave You Comments</h3>
			<form method="post" action="#!" id="form" role="form">
				<div className="row">
					<div className="col-md-6 form-group">
						<input
							type="text"
							name="name"
							id="name"
							className=" form-control"
							placeholder="Name *"
							maxLength="100"
							required=""
						/>
					</div>
					<div className="col-md-6 form-group">
						<input
							type="email"
							name="email"
							id="email"
							className=" form-control"
							placeholder="Email *"
							maxLength="100"
							required=""
						/>
					</div>
					<div className="form-group col-md-12">
						<input
							type="text"
							name="website"
							id="website"
							className=" form-control"
							placeholder="Website"
							maxLength="100"
						/>
					</div>
					<div className="form-group col-md-12">
						<textarea
							name="text"
							id="text"
							className=" form-control"
							rows="6"
							placeholder="Comment"
							maxLength="400"></textarea>
					</div>
					<div className="form-group col-md-12">
						<button type="submit" className="btn btn-main ">
							Send comment
						</button>
					</div>
				</div>
			</form>
		</div>
	);
};

export default CommentForm;
