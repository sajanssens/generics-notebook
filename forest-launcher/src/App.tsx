import './App.css'

function DownloadIcon() {
    return (
        <svg className="download-icon" viewBox="0 0 24 24" width="16" height="16" fill="none"
             stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
            <path d="M12 3v12"/>
            <path d="M7 10l5 5 5-5"/>
            <path d="M5 21h14"/>
        </svg>
    )
}

function App() {

    function launch(event: React.MouseEvent<HTMLDivElement>) {
        if ((event.target as HTMLElement).closest('a')) return
        window.open(
            "https://mybinder.org/v2/gh/sajanssens/generics-notebook/HEAD?urlpath=notebooks/Generics.ipynb",
            "_blank",
            "noopener,noreferrer"
        )
    }

    return (
        <>
            <section id="center">
                <div className="launch-card" onClick={launch}>
                    <h1>Generics</h1>
                    <h2>Click here to launch the lab 🚀</h2>
                    <p>JFall 2026 🍁</p>
                </div>
                <hr/>
                <div className="resource-links">
                    <h2>Downloads</h2>
                    <a className="download-button" href="https://bramjanssens.nl/generics/GENERICS%20-%20you%20never%20know%20-%20short.pdf">
                        <DownloadIcon/> Slides
                    </a>
                    <a className="download-button" href="https://bramjanssens.nl/generics/Java%20Variance%20Cheat%20Sheet.jpg">
                        <DownloadIcon/> Cheat Sheet
                    </a>
                </div>
            </section>

            <div><a href="https://bramjanssens.nl">bramjanssens.nl</a></div>
            <div><a href="https://infosupport.com">infosupport.com</a></div>
        </>
    )
}

export default App
