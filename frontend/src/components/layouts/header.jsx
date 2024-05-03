import styles from './header.module.scss';
import NavBar from './navbar';
import imageLogo from '../../images/logo_emanuel.png';

const Header = () => {

    return (
        <header className={styles.container_header}>
            <img src={imageLogo} alt="logo-header" />
            <NavBar />
        </header>
    )
}

export default Header