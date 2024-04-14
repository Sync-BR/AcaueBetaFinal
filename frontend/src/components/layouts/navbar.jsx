import styles from './navbar.module.scss';
import SocialMedia from './socialMedia';
import { Link } from 'react-router-dom';

import { useState, useRef, useEffect } from 'react';


const NavBar = () => {

    const [menuOpen, setMenuOpen] = useState(false);
    const menuRef = useRef(null);

    useEffect(() => {
        const handleClickOutside = (event) => {
            if (menuRef.current && !menuRef.current.contains(event.target)) {
                setMenuOpen(false);
            }
        };

        document.addEventListener('mousedown', handleClickOutside);

        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        };
    }, []);

    const toggleMenu = () => {
        setMenuOpen(!menuOpen);
    };

    // console.log("referencia", menuRef)


    return (
        <nav className={styles.container_nav}>

            <input type="checkbox" id="menu_hamburguer" checked={menuOpen} onChange={toggleMenu} />

            <label htmlFor="menu_hamburguer" ref={menuRef}>
                <div className={styles.menu}>
                    <span className={styles.hamburguer}></span>
                </div>
            </label>


            <ul className={styles.navigation}>
                <li><Link to="/"> Inicio </Link></li>
                <li> <Link to="/portfolio"> Portfólio</Link></li>
                <li> <a href="#about"> Sobre Nós </a></li>
                <li> <a href='#contact'>Contato </a></li>
            </ul>

            <SocialMedia />



        </nav>
    )
}

export default NavBar