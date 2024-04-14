import styles from './about_us.module.scss'


const AboutUs = () => {

    return (
        <div id="about" className={styles.about_container}>
            <div >
                <p className={styles.title_about}>Sobre nós</p>
                <span></span>
            </div>

            <h3>Conheça nossa História</h3>

            <h2>Olá! Me chamo <span>Acauê Emanuel</span></h2>
            <ul className={styles.container_info_about}>
                <li>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.
                </li>
                <li>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.
                </li>
                <li>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.
                </li>
            </ul>


        </div>
    )
}

export default AboutUs