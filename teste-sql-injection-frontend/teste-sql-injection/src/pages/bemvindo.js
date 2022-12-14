import axios from "axios";
import { Component, useEffect, useState } from "react";
import { useNavigate, useNavigation } from "react-router-dom";
import React from "react";
import { ReactDOM } from "react";

export default class BemVindo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      name: "",
      email: "",
    };
  }


  render() {
    return (
      <div className="container">
        <h1>Bem Vindo!</h1>
      </div>
    );
  }
}
