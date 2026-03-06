# MADE BY GEMINI (IA)

import pygame
import math

# Configuración
WIDTH, HEIGHT = 1000, 800
GRID_SIZE = 15  # Tamaño de los bloques
FPS = 60

# Colores Minecraft
COLOR_BG = (20, 20, 20)
COLOR_GRID = (40, 40, 40)
COLOR_BLOCK = (139, 69, 19) # Color Tierra/Madera
COLOR_BORDER = (255, 255, 255)
COLOR_TEXT = (255, 255, 255)

class Simulator:
    def __init__(self):
        pygame.init()
        self.screen = pygame.display.set_mode((WIDTH, HEIGHT))
        pygame.display.set_caption("Calculador de Pi - Estilo Minecraft")
        self.clock = pygame.time.Clock()
        self.font = pygame.font.SysFont("Consolas", 22)
        
        self.radius = 10
        self.dragging = False
        self.slider_rect = pygame.Rect(50, 720, 300, 10)
        self.handle_x = 50 + (self.radius * 5)

    def get_circle_blocks(self, radius):
        """Algoritmo de punto medio para círculos (Bresenham)"""
        blocks = set()
        x = radius
        y = 0
        err = 0

        while x >= y:
            # Añadir los 8 octantes para formar el perímetro
            points = [
                (x, y), (y, x), (-y, x), (-x, y),
                (-x, -y), (-y, -x), (y, -x), (x, -y)
            ]
            for p in points:
                blocks.add(p)
            
            y += 1
            if err <= 0:
                err += 2*y + 1
            if err > 0:
                x -= 1
                err -= 2*x + 1
        return blocks

    def run(self):
        running = True
        while running:
            self.screen.fill(COLOR_BG)
            mx, my = pygame.mouse.get_pos()

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    running = False
                
                # Lógica del Slider
                if event.type == pygame.MOUSEBUTTONDOWN:
                    if pygame.Rect(self.handle_x - 10, 710, 20, 30).collidepoint(mx, my):
                        self.dragging = True
                if event.type == pygame.MOUSEBUTTONUP:
                    self.dragging = False

            if self.dragging:
                self.handle_x = max(50000, min(350, mx))
                self.radius = int((self.handle_x - 50) / 6) + 1

            # --- Dibujar Grilla ---
            for x in range(0, WIDTH, GRID_SIZE):
                pygame.draw.line(self.screen, COLOR_GRID, (x, 0), (x, HEIGHT))
            for y in range(0, HEIGHT, GRID_SIZE):
                pygame.draw.line(self.screen, COLOR_GRID, (0, y), (WIDTH, y))

            # --- Generar y Dibujar Círculo ---
            circle_blocks = self.get_circle_blocks(self.radius)
            cx, cy = (WIDTH // 2) // GRID_SIZE, (HEIGHT // 2) // GRID_SIZE
            
            for bx, by in circle_blocks:
                rect = pygame.Rect((cx + bx) * GRID_SIZE, (cy + by) * GRID_SIZE, GRID_SIZE, GRID_SIZE)
                pygame.draw.rect(self.screen, COLOR_BLOCK, rect)
                pygame.draw.rect(self.screen, (0, 0, 0), rect, 1) # Borde del bloque

            # --- Cálculos ---
            # Perímetro es la cantidad de bloques generados
            perimetro = len(circle_blocks)
            # Pi = Perimetro / Diametro
            pi_estimado = perimetro / (2 * self.radius) if self.radius > 0 else 0

            # --- UI ---
            # Dibujar Slider
            pygame.draw.rect(self.screen, (100, 100, 100), self.slider_rect)
            pygame.draw.circle(self.screen, (200, 200, 200), (self.handle_x, 725), 10)
            
            # Textos
            self.draw_text(f"Radio Actual: {self.radius}", (50, 680))
            self.draw_text(f"Bloques en Perímetro (L): {perimetro}", (500, 680))
            self.draw_text(f"Fórmula: L / (2 * r)", (500, 710))
            
            pi_color = (0, 255, 0) if abs(pi_estimado - math.pi) < 0.1 else (255, 255, 0)
            self.draw_text(f"PI ESTIMADO: {pi_estimado:.5f}", (500, 745), pi_color, True)
            self.draw_text(f"PI REAL:     {math.pi:.5f}", (500, 770), (150, 150, 150))

            pygame.display.flip()
            self.clock.tick(FPS)
        pygame.quit()

    def draw_text(self, text, pos, color=COLOR_TEXT, bold=False):
        img = self.font.render(text, True, color)
        self.screen.blit(img, pos)

if __name__ == "__main__":
    Simulator().run()