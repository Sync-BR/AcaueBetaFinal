import styles from './header.module.scss';
import NavBar from './navbar';

const Header = () => {

    return (
        <div className={styles.container_header}>
            <img src="https://placehold.jp/50x50.png" alt="logo-header" />
            <NavBar />
        </div>
    )
}

export default Header