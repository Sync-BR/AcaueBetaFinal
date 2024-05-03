import styles from './about_us.module.scss'
import { FaStar } from "react-icons/fa";



const AboutUs = () => {

    const aboutText = " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis."


    return (
        <div id="about" className={styles.about_container}>
            <div className={styles.header} >
                <p className={styles.title_about}>Sobre nós</p>
                <span></span>
            </div>

            <h3>Conheça nossa História</h3>

            <h2>Olá! Me chamo <span>Acauê Emanuel</span></h2>

            <section >

                <div className={`${styles.item} ${styles.first}`}>
                    <h5>
                        <FaStar className={styles.icon} size={16} />
                        <p className={styles.icon}>Sobre 1</p>
                    </h5>
                    <p className={styles.p_about}>{aboutText}</p>
                </div>

                <div className={` ${styles.item} ${styles.second} `}>
                    <h5>
                        <FaStar className={styles.icon} size={16} />
                        <p className={styles.icon}>Sobre 2</p>
                    </h5>
                    <p className={styles.p_about}>{aboutText}</p>
                </div>

                <div className={` ${styles.item} ${styles.third} `}>

                    <h5>
                        <FaStar className={styles.icon} size={16} />
                        <p className={styles.icon}>Sobre 3</p>
                    </h5>
                    <p className={styles.p_about}>{aboutText}</p>
                </div>
            </section>


        </div>
    )
}

export default AboutUs