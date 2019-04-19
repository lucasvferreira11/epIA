ep_ia_novo <- read_excel("USP/ultimoSemestre/ep_ia_novo.xlsx")

Generations <- ep_ia_novo$Epoca
Fitness <- ep_ia_novo$Fitness
Best <- ep_ia_novo$Best

plot(geracoes, fitness, type="l", xlab="Generations", ylab = "Fitness")

par(new=T)

plot (geracoes, best, type="l", axes=F, xlab = " ", lty=2, ylab =" ")

