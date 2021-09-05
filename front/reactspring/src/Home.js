import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import logo from './logo.svg';


class Home extends Component {
    render() {
        return (

            <div className="App">
                <AppNavbar/>
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <div className="App-intro">
                        <Button color="link"><Link to="/groups">Study Group</Link></Button>
                    </div>
                </header>
            </div>
        );
    }
}


export default Home;