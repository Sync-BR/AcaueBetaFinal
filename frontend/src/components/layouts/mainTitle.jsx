import styles from './main_title.module.scss'
import logoMain from '../../images/logo_main.png'

const MainTitle = () => {

    const handleContactClick = () => {
        if (window.innerWidth <= 768) {
            setTimeout(() => {
                window.location.href = '#contact';
            }, 500)
        }else {
            window.location.href = '#contact'
        }
    }

    return (
        <div className={styles.container_main}>

            <div className={styles.container_title}>
                <h1>Olá! Me chamo <br /> Acauê Emanuel</h1>
                <p>Trabalho com Brand Designer desde<br /> 2015, são mais de 500 Logo já produzidas<br /> conheça um pouco mais do meu trabalho abaixo </p>
                <a onClick={handleContactClick} className={styles.btn_contato}> Entre em contato </a>
            </div>

            <div className={styles.container_img}>
                <img src={logoMain} alt="image_logo" />
            </div>

        </div>
    )
}

export default MainTitle