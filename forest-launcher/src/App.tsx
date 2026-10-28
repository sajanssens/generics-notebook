import './App.css'

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
                    <h2>Click to launch the lab 🚀</h2>
                    <p>JFall 2026 🍁</p>
                </div>
            </section>
            <div><a href="https://bramjanssens.nl">bramjanssens.nl</a></div>
            <div><a href="https://infosupport.com">infosupport.com</a></div>
        </>
    )
}

export default App
