import styles from './social_media.module.scss';
import { FaWhatsapp, FaInstagram, FaBehance } from 'react-icons/fa';

import behance from '../../images/square-behance.svg'
import wpp from '../../images/square-wpp.svg'
import insta from '../../images/square-insta.svg'




const SocialMedia = ({ customClass }) => {

    return (
        <ul className={styles.container_network}>
            <span></span>
            <li className={`${styles.item} ${styles.insta_item} ${styles[customClass]}`}>
                <a href='#'>
                    <FaInstagram size={20} />
                </a>
            </li>

            <li className={`${styles.item} ${styles.wpp_item}`}>
                <a href='#'>
                    <FaWhatsapp size={20} />
                </a>
            </li>

            <li className={`${styles.item} ${styles.behance}`}>
                <a href='#'>
                    <FaBehance size={20} />
                </a>
            </li>


        </ul>

    )
}

export default SocialMedia;