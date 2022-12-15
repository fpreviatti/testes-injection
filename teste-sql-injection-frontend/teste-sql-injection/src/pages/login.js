import axios from "axios";
import { Component } from "react";

import React from "react";

export default class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      name: "",
      email: "",
      toDashboard: false,
    };
  }

  handleSubmit = (event) => {
    event.preventDefault();

    const url = "http://localhost:8080/login";

    const dados = {
      email: event.target.elements.email.value,
      senha: event.target.elements.senha.value,
    };

    console.log(dados);

    const config = {
      headers: {},
    };
    axios.post(url, dados, config).then(async (response) => {
      await new Promise((resolve) =>
        this.setState(
          {
            toDashboard: true,
          },
          resolve
        )
      )

      if (this.state.toDashboard) {
        console.log(response);
        //this.handleSession();
      }

      console.log(this.state.toDashboard);
    });
  };

  handleSession() {
    alert("Usuário e senha ok");
  }

  render() {
    return (
      <div className="container">
        <form onSubmit={this.handleSubmit} method="post">
          <label>Email</label>
          <br></br>
          <input name="email" id="email"></input>
          <br></br>

          <label>Senha</label>
          <br></br>
          <input name="senha" id="senha"></input>
          <br></br>
          <button type="submit">Login</button>
        </form>
      </div>
    );
  }
}
