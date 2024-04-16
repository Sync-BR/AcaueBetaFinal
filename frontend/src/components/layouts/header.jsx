import styles from './header.module.scss';
import NavBar from './navbar';

const Header = () => {

    return (
        <header className={styles.container_header}>
            <img src="https://placehold.jp/50x50.png" alt="logo-header" />
            <NavBar />
        </header>
    )
}

export default Header