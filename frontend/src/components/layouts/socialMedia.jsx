import styles from './social_media.module.scss';
import { FaWhatsapp, FaInstagram, FaBehance } from 'react-icons/fa';

import behance from '../../images/square-behance.svg'
import wpp from '../../images/square-wpp.svg'
import insta from '../../images/square-insta.svg'




const SocialMedia = ({ customClass }) => {

    return (
        <ul className={styles.container_network}>
            {/* <span></span> */}
            <li className={`${styles.item}  ${styles[customClass]}`}>
                <a href='#'>
                    <FaInstagram className={`${styles.insta_item} ${styles.icon}`} size={20} />
                </a>
            </li>

            <li className={`${styles.item}`}>
                <a href='#'>
                    <FaWhatsapp className={`${styles.wpp_item} ${styles.icon}`}  size={20} />
                </a>
            </li>

            <li className={`${styles.item} `}>
                <a href='#'>
                    <FaBehance className={`${styles.behance_item} ${styles.icon}`} size={20} />
                </a>
            </li>
        </ul>

    )
}

export default SocialMedia;