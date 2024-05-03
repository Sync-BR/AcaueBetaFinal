import styles from './navbar.module.scss';
import SocialMedia from './socialMedia';
import { Link, useLocation } from 'react-router-dom';

import { useState, useRef } from 'react';


const NavBar = () => {
    const location = useLocation()

    const [menuOpen, setMenuOpen] = useState(false);
    const menuRef = useRef(null);
    const timeoutRef = useRef(null)

    const toggleMenu = () => {
        setMenuOpen(!menuOpen);
        clearTimeout(timeoutRef.current);
        timeoutRef.current = setTimeout(() => {
            setMenuOpen(false);
        }, 5000);
        console.log("toggle", menuOpen)
    };

    const handleOptionClick = () => {

            setMenuOpen(false);

    };

    return (
        <nav className={styles.container_nav}>

            <input type="checkbox" id="menu_hamburguer" checked={menuOpen} onChange={toggleMenu} />

            <label htmlFor="menu_hamburguer" ref={menuRef}>
                <div className={styles.menu}>
                    <span className={styles.hamburguer}></span>
                </div>
            </label>


            <ul className={styles.navigation}>
                <li><Link className={styles.home} to="/" onClick={handleOptionClick}> Inicio </Link></li>
                <li> <Link to="/portfolio" onClick={handleOptionClick}> Portfólio</Link></li>

                {location.pathname !== '/portfolio' && (
                    <>
                        <li> <a href="#about" onClick={handleOptionClick}> Sobre Nós </a></li>
                        <li> <a href='#contact' onClick={handleOptionClick}>Contato </a></li>

                    </>
                )}
            </ul>

            <SocialMedia customClass='border_left' />



        </nav>
    )
}

export default NavBar