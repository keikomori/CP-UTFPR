################################################################################
# Automatically-generated file. Do not edit!
################################################################################

SHELL = cmd.exe

# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.c $(GEN_OPTS) | $(GEN_FILES) $(GEN_MISC_FILES)
	@echo 'Building file: "$<"'
	@echo 'Invoking: GNU Compiler'
	"C:/ti/ccs920/ccs/tools/compiler/gcc-arm-none-eabi-7-2017-q4-major-win32/bin/arm-none-eabi-gcc-7.2.1.exe" -c -mcpu=cortex-m4 -march=armv7e-m -mthumb -mfloat-abi=hard -mfpu=fpv4-sp-d16 -DPART_TM4C1294NCPDT -DTARGET_IS_TM4C129_RA1 -Dgcc -I"C:/Users/Crow/workspace_v9_2/FreeRTOS_10.0.1/FreeRTOS/include" -I"C:/Users/Crow/workspace_v9_2/FreeRTOS_10.0.1/FreeRTOS/portable/GCC/ARM_CM4F" -I"C:/Users/Crow/workspace_v9_2/FreeRTOS_10.0.1" -I"C:/Users/Crow/workspace_v9_2/FreeRTOS_10.0.1/FreeRTOS" -I"C:/ti/ccs920/ccs/tools/compiler/gcc-arm-none-eabi-7-2017-q4-major-win32/arm-none-eabi/include" -I"C:/ti/TivaWare_C_Series-2.1.4.178" -Og -ffunction-sections -fdata-sections -g -gdwarf-3 -gstrict-dwarf -Wall -specs="nosys.specs" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)"  $(GEN_OPTS__FLAG) -o"$@" "$<"
	@echo 'Finished building: "$<"'
	@echo ' '


