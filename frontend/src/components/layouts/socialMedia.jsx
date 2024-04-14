import styles from './social_media.module.scss';

import behance from '../../images/square-behance.svg'
import wpp from '../../images/square-wpp.svg'
import insta from '../../images/square-insta.svg'




const SocialMedia = () => {

    return (
        <ul className={styles.container_network}>
            <span></span>
            <li className={`${styles.item} ${styles.insta_item}`}>
            <a target="_blank" rel="noopener noreferrer" href="https://www.youtube.com/watch?v=mV0ST0aGfAo&ab_channel=Bert-Topic" title="Contact">
                    <img className={styles.img_insta} src={insta} alt="loho_insta" /></a>
            </li>

            <li className={`${styles.item} ${styles.wpp_item}`}>
                <a target="_blank" rel="noopener noreferrer" href="https://www.youtube.com/watch?v=mV0ST0aGfAo&ab_channel=Bert-Topic" title="Contact">
                    <img className={styles.img_wpp} src={wpp} alt="wpp" /></a>
            </li>

            <li className={`${styles.item} ${styles.behance}`}>
                <a target="_blank" rel="noopener noreferrer" href="https://www.youtube.com/watch?v=mV0ST0aGfAo&ab_channel=Bert-Topic" title="Contact">
                    <img className={styles.img_behance} src={behance} alt="Behance" />
                </a>
            </li>


        </ul>

    )
}

export default SocialMedia;