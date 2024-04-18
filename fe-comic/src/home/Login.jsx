import React, { useRef } from "react";
import ApiClient from "../assets/js/ApiClient";
import { useNavigate } from "react-router-dom";

const Login = () => {
	const userNameRef = useRef();
	const passwordRef = useRef();

	const navigate = useNavigate();

	const handleSubmit = async (e) => {
		e.preventDefault();
		const userName = userNameRef.current.value;
		const password = passwordRef.current.value;
		const formData = {
			userName: userName,
			password: password,
		};
		const resp = await ApiClient.post("/login", formData);
		if (resp.status == 200) {
			localStorage.setItem("token", resp.data.accessToken);
			navigate(-1);
		} else {
		}
	};
	return (
		<div className="container">
			<div className="row">
				<div className="col">
					<form onSubmit={handleSubmit} className="my-3" method="POST">
						<div className="form-group">
							<label htmlFor="userName">Email address</label>
							<input
								ref={userNameRef}
								type="text"
								className="form-control"
								id="userName"
								aria-describedby="emailHelp"
								placeholder="Enter user"
								name="userName"
							/>
							<small id="emailHelp" className="form-text text-muted">
								We'll never share your email with anyone else.
							</small>
						</div>
						<div className="form-group">
							<label htmlFor="exampleInputPassword1">Password</label>
							<input
								ref={passwordRef}
								type="password"
								className="form-control"
								id="exampleInputPassword1"
								placeholder="Password"
							/>
						</div>
						<button type="submit" className="btn btn-primary">
							Submit
						</button>
					</form>
				</div>
			</div>
		</div>
	);
};

export default Login;
