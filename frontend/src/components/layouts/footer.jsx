import SocialMedia from "./socialMedia"

import styles from './footer.module.scss'

const Footer = () => {

    return (
        <div className={styles.container_footer}>
            <span></span>
            <SocialMedia />
            <span></span>
        </div>
    )
}

export default Footer