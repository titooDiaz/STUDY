import time
import os
import subprocess
import mss
import mss.tools

# Carpeta donde se guardarán las capturas
OUT_DIR = "captures"
os.makedirs(OUT_DIR, exist_ok=True)

# Función para obtener la posición del mouse con xdotool
def get_mouse_position():
    output = subprocess.check_output(["xdotool", "getmouselocation"]).decode()
    x = int(output.split()[0].split(":")[1])
    y = int(output.split()[1].split(":")[1])
    return (x, y)

# Función para pedir al usuario mover el mouse y presionar ENTER
def ask_position(message):
    input(f"{message} y presiona ENTER...")
    pos = get_mouse_position()
    print(f"Seleccionado: {pos}")
    return pos

# Función para seleccionar la región de captura
def ask_region():
    print("Selecciona la región de captura:")
    top_left = ask_position("Coloca el mouse en la ESQUINA SUPERIOR IZQUIERDA")
    bottom_right = ask_position("Coloca el mouse en la ESQUINA INFERIOR DERECHA")

    x1, y1 = top_left
    x2, y2 = bottom_right

    left = min(x1, x2)
    top = min(y1, y2)
    width = max(abs(x2 - x1), 1)
    height = max(abs(y2 - y1), 1)

    region = {"left": left, "top": top, "width": width, "height": height}
    print(f"Región seleccionada: {region}")
    return region

# Función para guardar la captura usando mss
def save_screenshot(region, filename):
    with mss.mss() as sct:
        monitor = {
            "left": region["left"],
            "top": region["top"],
            "width": region["width"],
            "height": region["height"]
        }
        img = sct.grab(monitor)
        mss.tools.to_png(img.rgb, img.size, output=filename)
        print(f"Captura guardada: {filename}")

# Función para hacer click en la posición seleccionada
def do_click(pos):
    subprocess.call([
        "xdotool",
        "mousemove", str(pos[0]), str(pos[1]),
        "click", "1"
    ])

# Función principal
def main():
    n = int(input("¿Cuántas veces quieres repetir el proceso?: "))
    delay_start = int(input("¿Cuántos segundos esperar antes de iniciar?: "))
    print(f"\nEsperando {delay_start} segundos...")
    time.sleep(delay_start)

    # Selección interactiva solo una vez
    region = ask_region()
    click_pos = ask_position("Mueve el mouse a la posición donde quieres hacer click después de cada captura")

    for i in range(n):
        print(f"\n▶ Iteración {i+1}/{n}")
        # Guardar captura
        filename = os.path.join(OUT_DIR, f"screenshot_{i+1}.png")
        save_screenshot(region, filename)
        time.sleep(0.2)  # Pequeña pausa
        # Hacer click automáticamente
        do_click(click_pos)
        time.sleep(0.7)

    print("\nProceso terminado.")

if __name__ == "__main__":
    main()

