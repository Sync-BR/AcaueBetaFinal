import styles from './main_title.module.scss'


const MainTitle = () => {

    return (
        <div  className={styles.container_main}>

            <div className={styles.container_title}>
                <h1>Olá! Me chamo <br /> Acuae Emanuel</h1>
                <p>Trabalho com Brand Designer desde<br/> 2015, são mais de 500 Logo já produzidas<br/> conheça um pouco mais do meu trabalho abaixo </p>
                <a href='#about' className={styles.btn_contato}> Entre em contado </a> 
            </div>

            <div className={styles.container_img}>
                <img src="https://placehold.jp/400x300.png" alt="image_logo" />
            </div>
        
        </div>
    )
}

export default MainTitle